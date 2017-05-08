package com.quartz.controller;

import com.quartz.dao.ScheduleJobDao;
import com.quartz.entity.ScheduleJob;
import com.quartz.model.RetObj;
import com.quartz.service.ScheduleJobService;
import com.quartz.utils.SpringUtils;

import org.apache.commons.lang.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("job")
public class ScheduleJobController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ScheduleJobDao scheduleJobDao;
	@Autowired
	ScheduleJobService scheduleJobService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("add")
	@ResponseBody
	public RetObj add(HttpServletRequest request, ScheduleJob scheduleJob) {
		RetObj retObj = new RetObj();
		retObj.setFlag(false);

		try {
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
		} catch (Exception e) {
			retObj.setMsg("cron表达式有误，不能被解析！");
			return retObj;
		}

		Object obj = null;
		try {
			if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
				obj = SpringUtils.getBean(scheduleJob.getSpringId());
			} else {
				Class clazz = Class.forName(scheduleJob.getBeanClass());
				obj = clazz.newInstance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (obj == null) {
			retObj.setMsg("未找到目标类！");
			return retObj;
		} else {
			Class clazz = obj.getClass();
			Method method = null;
			try {
				method = clazz.getMethod(scheduleJob.getMethodName(), null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (method == null) {
				retObj.setMsg("未找到目标方法！");
				return retObj;
			}
		}

		try {
			scheduleJobService.addTask(scheduleJob);
		} catch (Exception e) {
			e.printStackTrace();
			retObj.setFlag(false);
			retObj.setMsg("保存失败，检查 name group 组合是否有重复！");
			return retObj;
		}

		retObj.setFlag(true);
		return retObj;
	}

	@RequestMapping("changeJobStatus")
	@ResponseBody
	public RetObj changeJobStatus(HttpServletRequest request, Long jobId, String cmd) {
		RetObj retObj = new RetObj();
		retObj.setFlag(false);
		try {
			scheduleJobService.changeStatus(jobId, cmd);
		} catch (SchedulerException e) {
			logger.error(e.getMessage(), e);
			retObj.setMsg("任务状态改变失败！");
			return retObj;
		}
		retObj.setFlag(true);
		return retObj;
	}

	@RequestMapping("jobList")
	public ModelAndView jobList(HttpServletRequest request) {
		List<ScheduleJob> jobList = scheduleJobDao.findAll();
		try {
			for (ScheduleJob job : jobList) {
				if ("1".equals(job.getJobStatus())) {
					scheduleJobService.addJob(job);
				}
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		request.setAttribute("jobList", jobList);
		return new ModelAndView("/jobList");
	}

	@RequestMapping("updateCron")
	@ResponseBody
	public RetObj updateCron(HttpServletRequest request, Long jobId, String cron) {
		RetObj retObj = new RetObj();
		retObj.setFlag(false);

		try {
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
		} catch (Exception e) {
			retObj.setMsg("cron表达式有误，不能被解析！");
			return retObj;
		}

		try {
			scheduleJobService.updateCron(jobId, cron);
		} catch (SchedulerException e) {
			retObj.setMsg("cron更新失败！");
			return retObj;
		}
		retObj.setFlag(true);
		return retObj;
	}

}
