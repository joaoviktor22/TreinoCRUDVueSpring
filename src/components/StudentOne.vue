<template>
    <div v-if="currentStudent" class="edit-form">
      <h4>Student</h4>
      <form>
        <div class="form-group">
          <label for="id">ID</label>
          <p style="color: red;">{{currentStudent.id}}</p>
        </div>
        <div class="form-group">
          <label for="nome">Nome</label>
          <input type="text" class="form-control" id="nome"
            v-model="currentStudent.nome"
          />
        </div>
        <div class="form-group">
          <label for="numero">Numero</label>
          <input type="text" class="form-control" id="numero"
            v-model="currentStudent.numero"
          />
        </div>
      </form>
  
      <button class="badge badge-danger mr-2"
        @click="deleteStudent"
      >
        Delete
      </button>
  
      <button type="submit" class="badge badge-success"
        @click="updateStudent"
      >
        Update
      </button>
      <p>{{ message }}</p>
    </div>
    
    <div v-else>
      <br />
      <p>Please click on a Student...</p>
    </div>
  </template>
  
  <script>
  import StudentService from "../services/StudentService";
  
  export default {
    name: "StudentOne",
    data() {
      return {
        currentStudent: null,
        message: ''
      };
    },
    methods: {
      getStudent(id) {
        StudentService.getStudentOne(id)
          .then(response => {
            this.currentStudent = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      },
  
      updateStudent() {
        StudentService.putStudentOne(this.currentStudent.id, this.currentStudent)
          .then(response => {
            console.log(response.data);
            this.message = 'The student was updated successfully!';
          })
          .catch(e => {
            console.log(e);
          });
      },
  
      deleteStudent() {
        StudentService.deleteStudentOne(this.currentStudent.id)
          .then(response => {
            console.log(response.data);
            this.$router.push({ name: "student" });
          })
          .catch(e => {
            console.log(e);
          });
      }
    },
    mounted() {
      this.message = '';
      this.getStudent(this.$route.params.id);
    }
  };
  </script>
  
  <style>
  .edit-form {
    max-width: 300px;
    margin: auto;
  }
  </style>
  