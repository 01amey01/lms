import FullCalendar from "@fullcalendar/react"
import dayGridPlugin from "@fullcalendar/daygrid"
import '../pageCss/Calendar.css'
import { useState, useEffect } from "react";
import { useHistory} from 'react-router-dom';
import { url } from './../Constants/constants';
import axios from 'axios';
import { useSelector } from "react-redux";
import { selectUser } from './../features/userSlice';

const Calendar = () => {
  const [assignments, setAssignments] = useState([])
    const [uAssignments, setUAssignments] = useState([])
    const [tests, setTests] = useState([])
    const [uTests, setUTests] = useState([])

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

    useEffect(() => {setUAssignments(removeDuplicates(assignments, "title"))}, [assignments])


    useEffect(() => { getTests() }, [])

    useEffect(() => {setUTests(removeDuplicates(tests, "title"))}, [tests])

    const history = useHistory() 

    const getAssignments = ()=>{
  
        axios.get(url+'/activity/course/assignment/calendar/'+user.id).then((response) => {
          const result = response.data
        if (result.status === 'success') {
            setAssignments(result.data);
            console.log(assignments);

        } else {
            alert('error occured')
        }
        })
}

const getTests = () => {

  axios.get(url + '/activity/course/test/calendar/'+user.id).then((response) => {
    const result = response.data
    if (result.status === 'success') {
      setTests(result.data);
      console.log(result.data)
    } else {
      alert('error occured')
    }
  })
}

const events = [...uAssignments, ...uTests]


    return <div>
    <h2 className="">CALENDAR</h2>
    <div className = "fullcalendar">
    <FullCalendar
     plugins={[ dayGridPlugin ]}
     initialView="dayGridMonth"
     events={events}
     //events={uTests}
     />
     </div>
    </div>
  }
  
  export default Calendar