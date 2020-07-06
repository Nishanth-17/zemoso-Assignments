import React from 'react'
import ModalVideo from 'react-modal-video'
import '../../../index.css';
import styled from 'styled-components'

class Poster extends React.Component {

  constructor (props) {
    super(props)
    this.state = {
      isOpen: false
    }
  }

  openModal = () => {
    this.setState({isOpen: true})
  }

  Button = styled.button`
  border:none;
  position: absolute;

  margin-left: 50px;
  margin: 0;
  margin-top: -110px;
  margin-left: 70px;
  background: transparent;
  color:rgb(212, 212, 212);
  transition: all 0.3s ease-in-out;

  .fa{
    margin-left: 50px;
    font-size: 50px;
  }

  &:hover,&:focus {
    cursor: pointer;
    background: transparent;
    font-size:60px;
    outline: none;
    color:white;
  }
  `
  render () {
    return (
      <div>
        <img src={this.props.image} alt="movie-poster" style={{height:'170px',width:'298px'}}/>
        <div className="modalVideo" data-testid="modal">
            <ModalVideo  channel='youtube' isOpen={this.state.isOpen} videoId={this.props.video}  onClose={() => this.setState({isOpen: false})} />
        </div>
        <this.Button onClick={this.openModal} className="button" id="videolink">
                <i className="fa fa-play-circle" arial-hidden="true"></i>
        </this.Button>
      </div>
    )
  }
}
export default Poster;