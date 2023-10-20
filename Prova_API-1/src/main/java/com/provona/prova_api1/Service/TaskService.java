package com.provona.prova_api1.Service;

import org.springframework.stereotype.Service;
import com.provona.prova_api1.Entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TaskService {

        private List<Task> tasks;

        public TaskService(){
            tasks = new ArrayList<>();
        }

        public List<Task> buscarTasks(){
            return tasks;
        }

        public Task criarTask(Task task) throws Exception { //Criar Task//
            tasks.add(task);
            return task;
        }

        public Task buscarTask(Long codigo) throws Exception {//Buscar Task//
            Optional<Task> task = tasks.stream().filter
                    (e -> e.getCodigo() == codigo).findFirst();
            if(task.isPresent()){
                return task.get();
            } else {
                throw new Exception("Task não encontrado!");
            }
        }

        public Task alterarTask(Long codigo, Task task) throws Exception {//Alterar Task//
            Optional<Task> produtoDaBase = tasks.stream().filter
                    (e -> e.getCodigo() == codigo).findFirst();
            if(produtoDaBase.isPresent()){
                produtoDaBase.get().setNome(task.getNome());
                produtoDaBase.get().setDescricao(task.getDescricao());
                produtoDaBase.get().setStatus(task.getStatus());
                return task;
            } else {
                throw new Exception("Task não encontrado!");
            }
        }
        public Task alterarStatusTask(Long codigo, Task task) throws Exception {//Alterar Status Task//
            Optional<Task> produtoDaBase = tasks.stream().filter
                    (e -> e.getCodigo() == codigo).findFirst();
            if(produtoDaBase.isPresent()){
                produtoDaBase.get().setStatus(task.getStatus());
                return task;
            } else {
                throw new Exception("Task não encontrado!");
            }
        }
        public void removerTask(Long codigo) {
            tasks.removeIf(tesk -> tesk.getCodigo() == codigo);
        }
    }
