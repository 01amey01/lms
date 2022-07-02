import React from 'react'
import './Card.css'

const Card = () => {
    return (
        <div>
            <div className="row row-cols-1 row-cols-md-2 g-4">
  <div className="col">
    <div className="card">
      <img src={process.env.PUBLIC_URL + `/images/img1.jpg`} className="card-img-top" alt="..." />
      <div className="card-body">
        <h3 className="card-title">Learning Management System</h3>
        <p className="card-text">LMS is a software application for the administration, documentation, tracking, reporting, automation and delivery of educational courses, training programs, or learning and development programs. LMSs include intelligent algorithms to make automated recommendations for courses based on a user's skill profile as well as extract metadata from learning materials in order to make such recommendations even more accurate.</p>
      </div>
    </div>
  </div>
  <div className="col">
    <div className="card">
      <img src={process.env.PUBLIC_URL + `/images/img2.jpg`} className="card-img-top" alt="..."/>
      <div className="card-body">
        <h3 className="card-title">Accessible for all</h3>
        <p className="card-text">Anyone can easily start their favourite course anytime. Our integrated content accessibility checkers also help you build courses that accomodate all learners. These course spaces are where educators create and arrange a wide array of resources and activities into a rich learning experience where enrolled learners have the ability to interact and work with each other to achieve the learning goals of the course.</p>
      </div>
    </div>
  </div>
  <div className="col">
    <div className="card">
      <img src={process.env.PUBLIC_URL + `/images/img3.jpg`} className="card-img-top" alt="..."/>
      <div className="card-body">
        <h3 className="card-title">Monitor Progress</h3>
        <p className="card-text">One of the most important features an LMS offers (and a huge time-saver) is the ability to track and monitor learner progress in real time. Whether you're dealing with 10 or 10,000 students, an LMS gives you automated and quick access to course enrollment statistics, attendance records, student grades, and many other performance metrics.</p>
      </div>
    </div>
  </div>
  <div className="col">
    <div className="card">
      <img src={process.env.PUBLIC_URL + `/images/img4.jpg`} className="card-img-top" alt="..."/>
      <div className="card-body">
        <h3 className="card-title">Flexible Learning</h3>
        <p className="card-text">It is designed for ultimate flexibility. A pedagogical toolbox designed from a social constructionist point of view that empowers you to build your own education platform to teach the way you want, to any number of learners. You can provide tasks that allow for active participation, exploration and experimentation through Assignments or Quiz; or keep learners up to date with course requirements or changes with Calendar, Notifications and Messaging, LMS can support your online education style.</p>
      </div>
    </div>
  </div>
        </div>
        
        </div>
    )
}

export default Card