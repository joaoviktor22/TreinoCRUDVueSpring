<template>
    <div class="hello">
        <li class="nav-item">
          <router-link to="/employees" class="nav-link">Employee</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/student" class="nav-link">Student</router-link>
        </li>
    </div>
  </template>
  
  <script>
  export default {
    name: 'HelloWorld',
    props: {
      msg: String
    }
  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  h3 {
    margin: 40px 0 0;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
  </style>
  