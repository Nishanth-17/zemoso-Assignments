import React ,{Component} from 'react';
import MovieCard from '../molecules/MovieCard';
import SearchBar from '../atoms/SearchBar/SearchBar';

export default class MovieList extends Component{
     constructor(){
         super();
         this.state={
             search:''
         }
     }

    filteredMovies=[];

    updateSearch = (event) => {
        this.setState({search: event.target.value});
    }

    render(){
        this.filteredMovies=this.props.movies.filter(
            (movie) => {
                return movie.title.toLowerCase().indexOf(this.state.search.toLowerCase()) !== -1;
            }
        );
        let result='';
        if(this.filteredMovies.length === 0)
        {
            result='No Results Found';
        }
        else if(this.filteredMovies.length === 1)
        {
            result='1 Result Found';
        }
        else if(this.filteredMovies.length !== this.props.movies.length) {
            result= this.filteredMovies.length + ' Results Found';
        }
        
        return(
            <div>
                <SearchBar value={this.state.search} changed={this.updateSearch} result={result} />
                
                <div className="card-deck">
                {
                    this.filteredMovies.map(movie => <MovieCard key={movie.id} movie={movie} />)
                }
            </div>
            </div>
        )
            }
    }

