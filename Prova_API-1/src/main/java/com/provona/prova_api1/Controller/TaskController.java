package com.provona.prova_api1.Controller;

import com.provona.prova_api1.Entity.Task;
import com.provona.prova_api1.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
        private final TaskService taskService;

        public TaskController(TaskService taskService) {
            this.taskService = taskService;
        }

        @GetMapping("todas")
        public ResponseEntity<?> buscarTask(){
            try {
                List<Task> lista =
                        taskService.buscarTasks();
                return new ResponseEntity(lista, HttpStatus.OK);
            } catch (Exception ex){
                return new ResponseEntity<>
                        ("Erro na requisição",
                                HttpStatus.BAD_GATEWAY);
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?> criarTask(@RequestBody Task task){
            try{
                task = taskService.criarTask(task);
                return new ResponseEntity<>(task, HttpStatus.CREATED);
            }catch (Exception exception){
                return new ResponseEntity(exception.getMessage(),
                        HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping("/{codigo}")
        public ResponseEntity<?> buscarProduto(@PathVariable("codigo") Long codigo){
            try {
                Task task = taskService.buscarTask(codigo);
                return new ResponseEntity(task.getDescricao(), HttpStatus.OK);
            } catch (Exception ex){
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }

        @PutMapping("alterar/{codigo}")
        public ResponseEntity<?> alterarTask(@RequestBody Task task, @PathVariable("codigo") Long codigo){
            try{
                task = taskService.alterarTask(codigo, task);
                return new ResponseEntity<>(task, HttpStatus.CREATED);
            }catch (Exception exception){
                return new ResponseEntity(exception.getMessage(),
                        HttpStatus.BAD_REQUEST);
            }
        }
    @PutMapping("alterarstatus/{codigo}")
    public ResponseEntity<?> alterarStatusTask(@RequestBody Task task, @PathVariable("codigo") Long codigo){
        try{
            task = taskService.alterarTask(codigo, task);
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

        @DeleteMapping("remover/{codigo}")
        public ResponseEntity<?> removerTask(@PathVariable("codigo") Long codigo){
            try {
                taskService.removerTask(codigo);
                return new ResponseEntity("Task Removida com Sucesso", HttpStatus.OK);
            } catch (Exception ex){
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
    }



