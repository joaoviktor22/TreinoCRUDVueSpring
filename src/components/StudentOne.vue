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
  
      <button style="background-color: red;color: black;" class="badge badge-danger mr-2"
        @click="deleteStudent"
      >
        Delete
      </button>
  
      <button style="background-color: yellow;margin-left: 10px;color: black;" type="submit" class="badge badge-success"
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
            this.showUpdateSuccess();
          })
          .catch(e => {
            this.showUpdateError();
            console.log(e);
          });
      },
  
      deleteStudent() {
        StudentService.deleteStudentOne(this.currentStudent.id)
          .then(response => {
            console.log(response.data);
            this.$router.push({ name: "student" });
            this.showDeleteSuccess();
          })
          .catch(e => {
            console.log(e);
            this.showDeleteError();
          });
      }
    },
    notifications: {
      showUpdateError: { // You can have any name you want instead of 'showLoginError'
        title: 'Update Error',
        message: 'Falhou ao dar Update',
        type: 'error' // You also can use 'VueNotifications.types.error' instead of 'error'
      },
      showUpdateSuccess: { // You can have any name you want instead of 'showLoginError'
        title: 'Update Success',
        message: 'Sucesso ao dar Update',
        type: 'success' // You also can use 'VueNotifications.types.error' instead of 'error'
      },
      showDeleteError: { // You can have any name you want instead of 'showLoginError'
        title: 'Delete Error',
        message: 'Falhou ao dar Delete',
        type: 'error' // You also can use 'VueNotifications.types.error' instead of 'error'
      },
      showDeleteSuccess: { // You can have any name you want instead of 'showLoginError'
        title: 'Delete Success',
        message: 'Sucesso ao dar Delete',
        type: 'success' // You also can use 'VueNotifications.types.error' instead of 'error'
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
  