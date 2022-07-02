import { useState, useEffect } from "react";
import { useHistory} from 'react-router-dom';
import { url } from './../Constants/constants';
import axios from 'axios';
import '../pageCss/Grades.css'
import { useSelector } from "react-redux";
import { selectUser } from './../features/userSlice';




const Grades = () => {

const [assignments, setAssignments] = useState([])
const [marks, setMarks] = useState([])

const user = useSelector(selectUser)

const history = useHistory() 

useEffect(() => {getAssignments()}, [])

const getAssignments = ()=>{
  
            axios.get(url+'/activity/course/assignment/'+user.id).then((response) => {
              const result = response.data
            if (result.status === 'success') {
                //console.log(result.data)
                setAssignments(result.data)
                console.log(assignments);
            } else {
                alert('error occured')
            }
            })

}

const updateMarks = (id)=>{

   const data ={"id":id,"marks":marks}
  
            axios.put(url+'/activity/assignment/updateAssignment',data).then((response) => {
              const result = response.data
            if (result.status === 'success') {
              alert('successfully marks are updated')
              history.push('/Activity')
            } else {
                alert('error occured')
            }
            })

}


    return <div className = "grades">
      <h2 className="">GIVE GRADES</h2>
    <div className="table-responsive">
      <table className="table table-striped">
  <thead>
    <tr>
      <th>#</th>
      <th>Assignment Name</th>
      <th>Commensement date</th>
      <th>End date</th>
      <th>Status</th>
      <th>Marks</th>
      <th>Student Id</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
  {assignments.map((assignment)=>{
        return ( 
        <tr>
        <th scope="row">{assignment.id}</th>
        <td>{assignment.name}</td>
        <td>{assignment.createdDate}</td>
        <td>{assignment.endDate}</td>
        <td>{assignment.status}</td>
        <td>{assignment.marks}</td>
        <td>{assignment.studentId}</td>
        <td >
        <input onChange={(e)=>{setMarks(e.target.value)}}
        type="text" class="form-control" id="addMarks" placeholder="Give marks">
        </input>
        <button onClick={(e)=>{updateMarks(assignment.id)}} type="button" id = "updateButton" class="btn btn-success">Give marks</button>
        </td>
        </tr> 
        )
    })}
  </tbody>
</table>
</div>
<div>
<button onClick={(e)=>{history.push('/Activity')}} type="button" class="btn btn-success">Back</button>
</div>
     
    </div> 
  }
  
  export default Grades