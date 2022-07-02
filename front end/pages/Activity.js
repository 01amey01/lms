import Assignment from './AssignmentActivity';
import Test from './TestActivity';
import '../pageCss/Activity.css'

const Activity = () => {
    return <div className = "activity">
        <div>
            <Assignment/>
        </div>
        <div>
            <Test/>
        </div>
        </div> 
  }
  
  export default Activity
