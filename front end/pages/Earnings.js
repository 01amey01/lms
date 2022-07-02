import { useState, useEffect } from "react";
import { url } from './../Constants/constants';
import axios from 'axios';
import { useSelector } from "react-redux";
import { selectUser } from './../features/userSlice';

const Earnings = () => {

    const [earning, setEarning] = useState([])

    useEffect(() => {getEarning()}, [])

    const user = useSelector(selectUser)

    const getEarning = () =>{

        axios.get(url+'/instructors/'+user.id).then((response) => {
          const result = response.data
        if (result.status === 'success') {
            setEarning(result.data)
            console.log(earning)
        } else {
            alert('error occured')
        }
        })
}




    return <div>
        <h1>Earnings</h1>
    <h1>Name - {earning.name}</h1>
    <h1>Earning for this course - {earning.earning}/ Rs</h1>
    </div>
}

export default Earnings