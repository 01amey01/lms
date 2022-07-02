import React from 'react';
import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import * as IoIcons from 'react-icons/io';

export const SidebarData = [
  {
    title: 'Login',
    path: '/Login',
    icon: <AiIcons.AiFillHome />,
    cName: 'nav-text'
  },
  {
    title: 'MANAGE ACTIVITIES',
    path: '/activity',
    icon: <IoIcons.IoIosPaper />,
    cName: 'nav-text'
  },
  {
    title: 'ADD GRADES',
    path: '/grades',
    icon: <FaIcons.FaCartPlus />,
    cName: 'nav-text'
  },
  {
    title: 'CALENDAR',
    path: '/calendar',
    icon: <IoIcons.IoMdPeople />,
    cName: 'nav-text'
  },
  {
    title: 'VIEW FEEDBACK & EARNINGS',
    path: '/feedback',
    icon: <FaIcons.FaEnvelopeOpenText />,
    cName: 'nav-text'
  }
];