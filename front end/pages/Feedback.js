import { useState, useEffect } from "react";
import {useHistory} from 'react-router-dom';
import { url } from './../Constants/constants';
import axios from 'axios';
import { useSelector } from "react-redux";
import { selectUser } from './../features/userSlice';


const Feedback = () => {
    const [feedbacks, setFeedbacks] = useState([])

    useEffect(() => {getFeedbacks()}, [])

    const user = useSelector(selectUser)

    const getFeedbacks = ()=>{
  
        axios.get(url+'/instructors/feedback/'+user.id).then((response) => {
          const result = response.data
        if (result.status === 'success') {
            setFeedbacks(result.data)
        } else {
            alert('error occured in feedback')
        }
        })
}
    return <div>
        <h1>Feedback</h1>
        <h1>{feedbacks.map((feedback)=>{
        return ( 
        <tr>
        <th > Student RollNo -{feedback.studentId}</th>
        <td> <br/> Feedback - {feedback.feedback}</td>
        {/* <td>{assignment.createdDate}</td>
        <td>{assignment.endDate}</td> */}
        {/* <td>{assignment.status}</td>
        <td>{assignment.marks}</td>
        <td>{assignment.studentId}</td> */}
        {/* <td><button onClick={(e)=>{deleteAssignment(assignment.id)}} type="button" id = "deleteButton" class="btn btn-danger">Delete Assignment</button></td> */}
        </tr> 
        )
    })}
    </h1>
    </div>
}

export default Feedback