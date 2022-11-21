import Vue from "vue";
import Router from "vue-router";


Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "menu",
      component: () => import("./components/Menu")
    },
    {
        path: "/employees",
        name: "employees",
        component: () => import("./components/Employee")
    },
    {
        path: "/student/:id",
        name: "student-details",
        component: () => import("./components/StudentOne")
    },
    {
      path: "/student",
      name: "student",
      component: () => import("./components/Student")
    }
  ]
});
