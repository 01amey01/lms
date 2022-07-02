import { useState, useEffect } from 'react'
import {useHistory} from 'react-router-dom'
import { url } from './../Constants/constants';
import axios from 'axios'
import '../pageCss/AddTest.css'

const AddAssignment = () => {

    const [name, setName] = useState([])
    const [enddate, setEndDate] = useState([])
    const [courseid, setCourseId] = useState([])
    const [studentid, setStudentId] = useState([])
    

    const history = useHistory() 

    const addAssignmentToRecord = () => {
        if (name.length === 0) {
            alert('enter name')
          } else if (enddate.length === 0) {
            alert('enter date')
          } else if (courseid.length === 0) {
            alert('enter courseid')
          }else if (studentid.length === 0) {
            alert('enter studentid')
          }
          else {

            const data ={"testName":name,"endDate":enddate,"courseNo":courseid,"studentNo":studentid}

            axios.post(url + '/activity/test/addTest', data).then((response) => {
              const result = response.data
              if (result.status === 'success') {
                alert('successfully added new test to the record')
                history.push('/Activity')
              } else {
                console.log(result.error)
                alert('error while adding the test to the record')
              }
            })
          }
    }




    return <div>
        <h1>Schedule a Test</h1>
        <div class="mb-3">
        <label for="formGroupExampleInput" class="form-label">Name</label>
        <input onChange={(e)=>{setName(e.target.value)}}
        type="text" class="form-control" id="formGroupExampleInput" placeholder="Enter Test name">
        </input>
        </div>
        <div class="mb-3">
        <label for="formGroupExampleInput2" class="form-label">Enddate</label>
        <input onChange={(e)=>{setEndDate(e.target.value)}} type="date" class="form-control" id="formGroupExampleInput" placeholder="Enter Due Date">
        </input>
        </div>
        <div class="mb-3">
        <label for="formGroupExampleInput2" class="form-label">Course ID</label>
        <input onChange={(e)=>{setCourseId(e.target.value)}} type="text" class="form-control" id="formGroupExampleInput" placeholder="Enter courseId">
        </input>
        </div>
        <div class="mb-3">
        <label for="formGroupExampleInput2" class="form-label">Student ID</label>
        <input onChange={(e)=>{setStudentId(e.target.value)}} type="text" class="form-control" id="formGroupExampleInput" placeholder="Enter studentId">
        </input>
        </div>
        <button onClick={(e)=>{addAssignmentToRecord()}} type="button" class="btn btn-success">Add</button>
        <button onClick={(e)=>{history.push('/Activity')}} type="button" class="btn btn-danger">Back</button>
        </div> 
  }
  
  export default AddAssignment