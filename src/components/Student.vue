<template>
    <div class="container">
        <h1 class="text-center"> Students List</h1>
        <table class="table table-striped">
            <thead>
                <th> Student ID </th>
                <th> Student Nome</th>
                <th> Student Numero</th>
                <td> Editar </td>
            </thead>
            <tbody>
                <tr v-for = "student in students" v-bind:key = "student.id">
                    <td>{{student.id}}</td>
                    <td>{{student.nome}}</td>
                    <td>{{student.numero}}</td>
                    <td><a style="background-color: green;color: branco" class="badge badge-warning" :href="'/student/' + student.id">Edit</a></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import StudentService from '../services/StudentService'

    export default{
        name: 'GetStudent',
        data(){
            return{
                students : []
            }
        },
        methods: {
            getStudent(){
                StudentService.getStudent().then((response) =>{
                    this.students = response.data;
                });
            }
        },
        created(){
            this.getStudent()
        }
    }
</script>