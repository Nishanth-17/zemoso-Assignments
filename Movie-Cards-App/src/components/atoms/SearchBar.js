import React from 'react';
import styled from 'styled-components';
import '../../index.css'

  
const SearchBar =(props) => {
    return(
    <div className="form-group has-search">
        <span className="fa fa-search form-control-feedback"></span>
        <input  style={{display:'inline-block'}}  type="text" className="form-control" size="40" value={props.value} onChange={props.changed} placeholder="Search by Movie Name..." /> 
        <p className={props.result==='No Results Found' ? 'text-results' : ''} style={{display:'inline-block',fontSize:'18px',color:'gray'}}>{props.result}</p>
    </div>
    );
}
export default SearchBar;