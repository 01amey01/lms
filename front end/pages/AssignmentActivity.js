import { useState, useEffect } from "react";
import { Link, useHistory} from 'react-router-dom';
import { url } from './../Constants/constants';
import axios from 'axios';
import '../pageCss/Assignment.css'
import { useSelector } from "react-redux";
import { selectUser } from './../features/userSlice';

const Assignment = () => {
    const [assignments, setAssignments] = useState([])
    const [uAssignments, setUAssignments] = useState([])

    const user = useSelector(selectUser)


    

    function removeDuplicates(originalArray, prop) {
      var newArray = [];
      var lookupObject  = {};
 
      for(var i in originalArray) {
         lookupObject[originalArray[i][prop]] = originalArray[i];
      }
 
      for(i in lookupObject) {
          newArray.push(lookupObject[i]);
      }
       return newArray;
  }
 


    useEffect(() => {getAssignments()}, [])

    useEffect(() => {setUAssignments(removeDuplicates(assignments, "name"))}, [assignments])

    // useEffect(() => {setUser(window.sessionStorage.getItem("user"))},[])

    // console.log(user);

    const history = useHistory() 

    const getAssignments = ()=>{
  
        axios.get(url+'/activity/course/assignment/'+user.id).then((response) => {
          const result = response.data
        if (result.status === 'success') {
            setAssignments(result.data)
        } else {
            alert('error occured')
        }
        })
}

const deleteAssignment = (id)=> {

    axios.delete(url + '/activity/assignment/'+id).then((response) => {
      const result = response.data
      if (result.status === 'success') {
        alert('successfully deleted assignment from the record')
        history.push('/activity')
      } else {
        console.log(result.error)
        alert('error while deleting assignment')
      }
    })
}




    return <div className = "container">
       <h1>Hello , {user.name}</h1>
        <h2 className="">ASSIGNMENTS</h2>
        <div className="table-responsive">
      <table className="table table-striped">
  <thead>
    <tr>
      <th>#</th>
      <th>Assignment Name</th>
      <th>Commensement date</th>
      <th>End date</th>
      {/* <th>Status</th>
      <th>Marks</th>
      <th>Student Id</th> */}
       <th>Action</th>
    </tr>
  </thead>
  <tbody>
  {uAssignments.map((assignment)=>{
        return ( 
        <tr>
        <th scope="row">{assignment.id}</th>
        <td>{assignment.name}</td>
        <td>{assignment.createdDate}</td>
        <td>{assignment.endDate}</td>
        {/* <td>{assignment.status}</td>
        <td>{assignment.marks}</td>
        <td>{assignment.studentId}</td> */}
        <td><button onClick={(e)=>{deleteAssignment(assignment.id)}} type="button" id = "deleteButton" class="btn btn-danger">Delete Assignment</button></td>
        </tr> 
        )
    })}
  </tbody>
</table>
</div>
<div>
<Link className="nav-link" to="/addAssignment">
    Add Assignment
</Link>
</div>
        
        </div> 
  }
  
  export default Assignment