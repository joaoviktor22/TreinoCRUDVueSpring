import axios from 'axios'

const EMPLOYEE_API_BASE_URL = 'http://localhost:8080/employees'

class EmployeeService{
    getEmployees(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }
    postEmployees(employee){
        return axios.post(EMPLOYEE_API_BASE_URL, employee);
    }
    getEmployeesOne(id){
        return axios.get(EMPLOYEE_API_BASE_URL+"/"+id);
    }
    deleteEmployees(id){
        return axios.delete(EMPLOYEE_API_BASE_URL+"/"+id);
    }
    putEmployeesOne(id,employee){
        return axios.put(EMPLOYEE_API_BASE_URL+"/"+id, employee);
    }
}

export default new EmployeeService()