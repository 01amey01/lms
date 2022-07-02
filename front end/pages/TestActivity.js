import { useState, useEffect } from "react";
import {Link,useHistory} from 'react-router-dom';
import { url } from './../Constants/constants';
import axios from 'axios';
import '../pageCss/Test.css'
import { selectUser } from './../features/userSlice';
import { useSelector } from "react-redux";

const Test = () => {
    const [tests, setTests] = useState([])
    const [uTests, setUTests] = useState([])

    const user = useSelector(selectUser)

    useEffect(() => {getTests()}, [])
    useEffect(() => {setUTests(removeDuplicates(tests, "name"))})


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

    const history = useHistory() 

    const getTests = ()=>{
  
        axios.get(url+'/activity/course/test/'+user.id).then((response) => {
          const result = response.data
        if (result.status === 'success') {
            setTests(result.data)
            setUTests(removeDuplicates(tests, "name")) 
            console.log(tests);
        } else {
            alert('error occured')
        }
        })
}

const deleteTest = (id)=> {

    axios.delete(url + '/activity/test/'+id).then((response) => {
      const result = response.data
      if (result.status === 'success') {
        alert('successfully deleted test from the record')
        history.push('/Activity')
      } else {
        console.log(result.error)
        alert('error while deleting test')
      }
    })
}



    return <div>
        <h2 className="">TESTS</h2>
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
  {uTests.map((test)=>{
        return ( 
        <tr>
        <th scope="row">{test.id}</th>
        <td>{test.name}</td>
        <td>{test.createdDate}</td>
        <td>{test.endDate}</td>
        {/* <td>{test.complitionStatus}</td>
        <td>{test.marks}</td>
        <td>{test.studentId}</td> */}
        <td><button onClick={(e)=>{deleteTest(test.id)}} type="button" id = "deleteButton" class="btn btn-danger">Delete Test</button></td>
        </tr> 
        )
    })}
  </tbody>
</table>
</div>
<div>
<Link className="nav-link" to="/addTest">
    Add Test
</Link>
</div>
        </div> 
  }
  

  export default Test