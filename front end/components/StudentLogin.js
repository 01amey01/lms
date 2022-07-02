import React, { useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import './Login.css'
import axios from 'axios'
import { useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';

const schema = yup.object().shape({
    email: yup.string().required('* email is a required field').email('* enter a valid email'),
    password: yup.string().required('* password is a required field'),
});


const StudentLogin = () => {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    const { register, handleSubmit, formState: { errors } } = useForm(
        {
            resolver: yupResolver(schema)
        }
    )

    const url = 'http://localhost:8080'
    const history = useHistory()
    const onSubmit = (data) => console.log(data)

    console.log(errors)

    const signIn = () => {
        const data = {
            "email": email,
            "password": password
        }

        axios.post(url + '/student/signin', data).then((response) => {
            const result = response.data
            console.log(result)
            if (result.status === 'success') {
                history.push('/Student', {
                    student: result.data
                })
            }

        })
    }

    return (
        <>
            <form className="modal-content animate" onSubmit={handleSubmit(onSubmit)}>
                <div className="imgcontainer">
                    <img className='img' src={process.env.PUBLIC_URL + `/images/student.svg`} />
                    <h3><b>Student</b></h3>
                </div>
                <div className="mb-3 margin">
                    <label className="form-label"><b>Email Address</b></label>
                    <input type="email" {...register('email')} onChange={((event) => { setEmail(event.target.value) })} name="email" className="form-control" placeholder="name@example.com" ></input>
                    <p className="p">{errors.email?.message}</p>
                </div>
                <div className="mb-3 margin">
                    <label className="form-label"><b>Password</b></label>
                    <input type="password" {...register('password')} onChange={((event) => { setPassword(event.target.value) })} name="password" className="form-control" placeholder="Enter Password"></input>
                    <p className="p">{errors.password?.message}</p>
                </div>
                <div className="btn-login">
                    <button type="submit" onClick={signIn} style={{ margin: "15px" }} className="btn btn-success " >Login</button>
                    <Link to="/Login"><button type="button" className="btn btn-danger ">Cancel</button></Link>
                </div>
            </form>
        </>
    )
}

export default StudentLogin
