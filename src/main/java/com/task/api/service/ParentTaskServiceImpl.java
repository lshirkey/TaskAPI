package com.task.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.api.dao.ParentTaskRepository;
import com.task.api.entity.ParentTask;
import com.task.api.model.ParentTaskUI;
import com.task.api.util.ParentTaskHelper;

@Service
public class ParentTaskServiceImpl implements ParentTaskService {

	@Autowired
	ParentTaskRepository parentTaskRepository;
	
	ParentTaskHelper parentTaskHelper = new ParentTaskHelper();
	
	@Override
	public ParentTaskUI viewParentTask(ParentTaskUI parentTaskUI) {
		ParentTaskUI ui = null;
		Optional<ParentTask> parentTaskList = parentTaskRepository.findById(parentTaskUI.getParentId());
		if (parentTaskList.isPresent()) {
			ui = parentTaskHelper.getParentTaskUI(parentTaskList.get());
		}
		return ui;
	}

//	@Override
//	public ParentTaskUI updateParentTask(ParentTaskUI parentTaskUI) {
//		ParentTask parentTask = parentTaskHelper.getParentTask(parentTaskUI);
//		return parentTaskHelper.getParentTaskUI(parentTaskRepository.save(parentTask));
//	}

//	@Override
//	public ParentTaskUI deleteParentTask(ParentTaskUI parentTaskUI) {
//		ParentTask ParentTask = parentTaskHelper.getParentTask(parentTaskUI);
//		return parentTaskHelper.getParentTaskUI(parentTaskRepository.save(ParentTask));
//	}

	@Override
	public ParentTaskUI addParentTask(ParentTaskUI parentTaskUI) {
		ParentTask ParentTask = parentTaskHelper.getParentTask(parentTaskUI);
		return parentTaskHelper.getParentTaskUI(parentTaskRepository.save(ParentTask));
	}

	@Override
	public List<ParentTaskUI> listParentTask() {
		Iterable<ParentTask> iterable = parentTaskRepository.findAll();
		Iterator<ParentTask> iterator = iterable.iterator();

		List<ParentTaskUI> parentTaskUIList = new ArrayList<ParentTaskUI>();
		while (iterator.hasNext()) {
			ParentTask parentTask = iterator.next();
			parentTaskUIList.add(parentTaskHelper.getParentTaskUI(parentTask));
		}
		return parentTaskUIList;
	}

//	@Override
//	public List<ParentTaskUI> searchParentTask(ParentTaskUI parentTaskUI) {
//		Iterable<ParentTask> iterable = parentTaskRepository.findAll();
//		Iterator<ParentTask> iterator = iterable.iterator();
//		
//		List<ParentTaskUI> parentTaskUIList = new ArrayList<ParentTaskUI>();
//		while (iterator.hasNext()) {
//			ParentTask parentTask = iterator.next();
//			parentTaskUIList.add(parentTaskHelper.getParentTaskUI(parentTask));
//		}
//		return parentTaskUIList;
//	}

//	@Override
//	public List<ParentTaskUI> searchParentTask(ParentTaskUI parentTaskUI, String sort) {
//		Iterable<ParentTask> iterable = parentTaskRepository.findAll();
//		Iterator<ParentTask> iterator = iterable.iterator();
//		
//		List<ParentTaskUI> parentTaskUIList = new ArrayList<ParentTaskUI>();
//		while (iterator.hasNext()) {
//			ParentTask parentTask = iterator.next();
//			parentTaskUIList.add(parentTaskHelper.getParentTaskUI(parentTask));
//		}
//		return parentTaskUIList;
//	}

}
