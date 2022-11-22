<template>
    <div class="container"><div class="submit-form">
        <h1 class="text-center"> Employees List</h1>
      <div class="form-group">
        <label for="age">Age</label>
        <input
          type="text"
          class="form-control"
          style="margin-right: auto;margin-left:auto;width: 20%"
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
          style="margin-right: auto;margin-left:auto;width: 20%"
          id="name"
          required
          v-model="employee.name"
          name="name"
        />
      </div>
      <button style="margin-top:5px" @click="saveEmployee" class="btn btn-success">Submit</button>
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
                    <td><button style="background-color: green;color: branco" class="badge badge-danger mr-2" @click="deleteEmployees(employee.id)">Delete</button></td>
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
                })
                .catch(e => {
                    this.showGetError();
                    console.log(e);
                });
            },
            deleteEmployees(id){
                EmployeeService.deleteEmployees(id).then((response) =>{
                    this.employees = response.data;
                    this.showDeleteSuccess();
                    this.getEmployees();
                })
                .catch(e => {
                    this.showDeleteError();
                    console.log(e);
                });
            },
            saveEmployee(){
                var data = {
                    age: this.employee.age,
                    name: this.employee.name
                };
                EmployeeService.postEmployees(data).then((response) =>{
                    this.employees = response.data;
                    this.showSaveSuccess();
                    this.getEmployees();
                })
                .catch(e => {
                    if(!data.age || !data.name){
                        this.showSaveErrorVazio();
                    }else if(data.age < 18){
                        this.showSaveErrorAge();
                    }else{
                        this.showSaveError();
                        console.log(e);
                    }
                });
            }
        },
        created(){
            this.getEmployees()
        },
        notifications: {
            showDeleteError: { // You can have any name you want instead of 'showLoginError'
                title: 'Delete Error',
                message: 'Falhou ao dar Delete',
                type: 'error' // You also can use 'VueNotifications.types.error' instead of 'error'
            },
            showDeleteSuccess: { // You can have any name you want instead of 'showLoginError'
                title: 'Delete Success',
                message: 'Sucesso ao dar Delete',
                type: 'success' // You also can use 'VueNotifications.types.error' instead of 'error'
            },
            showGetError: { // You can have any name you want instead of 'showLoginError'
                title: 'Get Error',
                message: 'Falhou ao mostrar Table',
                type: 'error' // You also can use 'VueNotifications.types.error' instead of 'error'
            },
            showSaveSuccess: { // You can have any name you want instead of 'showLoginError'
                title: 'Save Success',
                message: 'Sucesso ao dar Save',
                type: 'success' // You also can use 'VueNotifications.types.error' instead of 'error'
            },
            showSaveError: { // You can have any name you want instead of 'showLoginError'
                title: 'Save Error',
                message: 'Falhou ao dar Save',
                type: 'error' // You also can use 'VueNotifications.types.error' instead of 'error'
            },
            showSaveErrorAge: { // You can have any name you want instead of 'showLoginError'
                title: 'Save Error',
                message: 'Idade tem que ser maior que 18 anos!',
                type: 'error' // You also can use 'VueNotifications.types.error' instead of 'error'
            },
            showSaveErrorVazio: { // You can have any name you want instead of 'showLoginError'
                title: 'Save Error',
                message: 'Campo Vazio!',
                type: 'error' // You also can use 'VueNotifications.types.error' instead of 'error'
            }
        },
        mounted(){
            this.getEmployees()
        }
    }
</script>