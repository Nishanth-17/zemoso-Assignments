import React from 'react';
import '../../styles/components/header.css';

const Header = (props) => (
    <nav className="header navbar">
        <div className="container">
            <div className="row m-auto">
                <i className="fa fa-film fa-2x text-white my-auto"></i>
                <div className="h3 ml-3 my-auto text-light" href="/">{props.title}</div>
            </div>
        </div>
    </nav>
);

export default Header;