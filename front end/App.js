import './App.css';
import { BrowserRouter, Link, Route, Switch } from 'react-router-dom';
import Activity from './pages/Activity';
import Grades from './pages/Grades';
import Calendar from './pages/Calendar';
import FeedbackEarnings from './pages/FeedbackEarnings';
import AddAssignment from './pages/AddAssignment';
import AddTest from './pages/AddTest';
import Login from './components/Login';
import StaffLogin from './components/StaffLogin';
import Navbar from './components/Navbar';

function App() {
  return (

    
    <div className="App">
    <BrowserRouter>
    <div>
    <Navbar/>
    </div>
    

    <div className="container">
    <Switch>
    <Route path="/activity" component={Activity} />
    <Route path="/grades" component={Grades} />
    <Route path="/calendar" component={Calendar} />
    <Route path="/feedback" component={FeedbackEarnings} />
    <Route path="/addAssignment" component={AddAssignment} />
    <Route path="/addTest" component={AddTest} />
    <Route path="/Login" component={Login} />
    <Route path="/StaffLogin" component={StaffLogin} />
    </Switch>
    </div>


    </BrowserRouter>
    </div>
  );
}

export default App;
