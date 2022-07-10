package com.andri.service;

import java.util.Set;

import javax.swing.text.html.HTML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Service {

	@Autowired
	private ScheduledAnnotationBeanPostProcessor postProcessor;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ServiceApplication ServiceApplication;
	private static final String SCHEDULED_TASKS = "scheduledTasks";

	@RequestMapping(path = "/data")
	@ResponseBody
	public String getdata() {
		Set<ScheduledTask> setTasks = postProcessor.getScheduledTasks();
		if (!setTasks.isEmpty()) {
			try {
				return setTasks.toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return "No running tasks !";
		}
		return "data safafa";

	}

	@GetMapping(value = "/stop")
	@ResponseBody
	public String stopSchedule() {

		postProcessor.postProcessBeforeDestruction(ServiceApplication, SCHEDULED_TASKS);
		return "OK";
	}

}
