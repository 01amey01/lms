import React from 'react'
import { Grid, Paper, Avatar, } from '@material-ui/core'
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import './Login.css'
import { Link } from 'react-router-dom'
import { useSelector } from "react-redux";
import { selectUser } from './../features/userSlice';

const Login = () => {

    const user = useSelector(selectUser)

    const paperStyle = { padding: 15, height: '60vh', width: 280, margin: "20px auto" }
    const avatarStyle = { backgroundColor: '#1b5eaa', margin: '50px' }

    return (
        <>
            <Grid>
                <Paper elevation={10} style={paperStyle}>
                    <Grid align='center' >
                        <Avatar style={avatarStyle}><LockOutlinedIcon /></Avatar>
                        <h2>Login as</h2>
                        
                        <Link to="/StaffLogin"><button type="button" style={{ margin: "15px" }} className="btn btn-primary">Staff</button></Link>
                        
                        {/* <Link to="/StudentLogin"><button type="button" className="btn btn-secondary ">Student</button></Link> */}
                    </Grid>
                    <div className="inner-btn">
                        <img className='inner-img' src={process.env.PUBLIC_URL + `/images/staff.svg`} />
                        <img className='inner-img' src={process.env.PUBLIC_URL + `/images/student.svg`} />
                    </div>
                </Paper>
            </Grid>
        </>
    )

}

export default Login