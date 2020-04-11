package com.example.cache.controller;

import com.example.cache.model.Employee;
import com.example.cache.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController   
public class EmployeeController {

    @Autowired
    private CacheManager cacheManager; 

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "save",method = RequestMethod.POST) 
    public Employee save(Employee employee){
        return employeeService.save(employee);
    }

    @RequestMapping(value = "listEmployee",method = RequestMethod.GET) 
    public java.util.List<Employee> listEmployee() {
        return employeeService.findAll();
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE) 
    public void delete(@RequestParam("id")long id){
         employeeService.delete(id);
    }

    // clear all cache using cache manager
    @RequestMapping(value = "clearCache")
    public void clearCache(){
        for(String name:cacheManager.getCacheNames()){
            cacheManager.getCache(name).clear();
        }
    }
}
