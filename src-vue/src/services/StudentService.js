import axios from 'axios'

const STUDENT_API_BASE_URL = 'http://localhost:8080/students'

class StudentService{
    getStudent(){
        return axios.get(STUDENT_API_BASE_URL);
    }
    getStudentOne(id){
        return axios.get(STUDENT_API_BASE_URL+"/"+id);
    }
    deleteStudentOne(id){
        return axios.delete(STUDENT_API_BASE_URL+"/"+id);
    }
    postStudent(){
        return axios.post(STUDENT_API_BASE_URL);
    }
    putStudentOne(id,employee){
        return axios.put(STUDENT_API_BASE_URL+"/"+id,employee);
    }
}

export default new StudentService()