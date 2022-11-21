<template>
  <div id="app">
    <Employee />
    <Student />
  </div>
</template>

<script>
import Employee from './components/Employee.vue'
import Student from './components/Student.vue'

export default {
  name: 'App',
  components: {
    Employee,
    Student
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
