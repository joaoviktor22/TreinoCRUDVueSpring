<template>
    <div class="container"><div class="submit-form">
        <h1 class="text-center"> Employees List</h1>
      <div class="form-group">
        <label for="age">Age</label>
        <input
          type="text"
          class="form-control"
          id="age"
          required
          v-model="employee.age"
          name="age"
        />
      </div>

      <div class="form-group">
        <label for="name">Name</label>
        <input
          class="form-control"
          id="name"
          required
          v-model="employee.name"
          name="name"
        />
      </div>
      <button @click="saveEmployee" class="btn btn-success">Submit</button>
  </div>
        <table class="table table-striped">
            <thead>
                <th> Employee ID </th>
                <th> Employee Age</th>
                <th> Employee Name</th>
                <td> Deletar</td>
            </thead>
            <tbody>
                <tr v-for = "employee in employees" v-bind:key = "employee.id">
                    <td>{{employee.id}}</td>
                    <td>{{employee.age}}</td>
                    <td>{{employee.name}}</td>
                    <td><button class="badge badge-danger mr-2" @click="deleteEmployees(employee.id)">Delete</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import EmployeeService from '../services/EmployeeService'

    export default{
        name: 'GetEmployees',
        data(){
            return{
                employees : [],
                employee: {
                    id: null,
                    age: "",
                    name: ""
                }
            }
        },
        methods: {
            getEmployees(){
                EmployeeService.getEmployees().then((response) =>{
                    this.employees = response.data;
                });
            },
            deleteEmployees(id){
                EmployeeService.deleteEmployees(id).then((response) =>{
                    this.employees = response.data;
                    this.getEmployees();
                });
            },
            saveEmployee(){
                var data = {
                    age: this.employee.age,
                    name: this.employee.name
                };
                EmployeeService.postEmployees(data).then((response) =>{
                    this.employees = response.data;
                    this.getEmployees();
                });
            }
        },
        created(){
            this.getEmployees()
        },
        mounted(){
            this.getEmployees()
        }
    }
</script>