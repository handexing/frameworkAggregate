package com.quartz.dao;

import com.quartz.entity.ScheduleJob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author handx 908716835@qq.com
 * @date 2017年5月7日 下午5:44:29
 */

@Repository
public interface ScheduleJobDao extends JpaRepository<ScheduleJob, Long> {

}
