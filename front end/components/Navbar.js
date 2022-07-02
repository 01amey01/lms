import React, { useState } from 'react';
import * as FaIcons from 'react-icons/fa';
import { Link } from 'react-router-dom';
import { SidebarData } from './SidebarData';
import './Navbar.css';
import { IconContext } from 'react-icons';
import { useDispatch } from 'react-redux';
import { logout } from '../features/userSlice';

function Navbar() {
  const [sidebar, setSidebar] = useState(false);

  const showSidebar = () => setSidebar(!sidebar);

  const dispatch = useDispatch();

  return (
    <> 
      <IconContext.Provider value={{ color: '#fff' }} >
        <div class="navbar-new">
        <img src="images/lms.png" className="btn-media" />
        <Link to='#' className='menu-bars'>
            <FaIcons.FaBars onClick={showSidebar} />
        </Link>
        <Link to="/Login"><button type="button" className="btn btn-danger " >Logout</button></Link>
        </div>
        <nav className={sidebar ? 'nav-menu active' : 'nav-menu'}>
          <ul className='nav-menu-items' onClick={showSidebar}>
            <li className='navbar-toggle'>
            </li>
            {SidebarData.map((item, index) => {
              return (
                <li key={index} className={item.cName}>
                  <Link to={item.path}>
                    {item.icon}
                    <span>{item.title}</span>
                  </Link>
                </li>
              );
            })}
           
          </ul>
        </nav>
        {/* <div className="footer">
            Loged in
        </div>  */}
      </IconContext.Provider>
    </>
  );
}

export default Navbar;