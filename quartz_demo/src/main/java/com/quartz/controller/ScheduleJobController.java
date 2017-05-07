package com.quartz.controller;

import com.quartz.dao.ScheduleJobDao;
import com.quartz.entity.ScheduleJob;
import com.quartz.model.RetObj;
import com.quartz.service.ScheduleJobService;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
}
