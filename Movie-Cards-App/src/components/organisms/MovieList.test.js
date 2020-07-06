import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import MovieList from './MovieList'
import { __esModule } from 'react-modal-video';
import { fireEvent, render } from '@testing-library/react';
import SearchBar from '../atoms/SearchBar/SearchBar';

const movies=[{
    "title": "Avengers: Endgame",
    "genre": "Action/Sci-Fi",
    "description":"After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance.",
    "year": 2019,
    "imageUrl": "Endgame",
    "videoId": "hA6hldpSTF8",
    "rating": 4.9
}]

test('Testing the Search Bar', () => {
    const handleChange = jest.fn()
    const {container} = render(<SearchBar changed={handleChange} />)
    const input=container.firstChild.childNodes[1]
    fireEvent.change(input, { target: { value: 'a' } })
    expect(handleChange).toHaveBeenCalledTimes(1)
    expect(input.value).toBe('a')
})

jest.mock('./../molecules/MovieCard', () => ({
    __esModule: true,
    default: () => { return <div></div>}
}))

test("Match the snapshot - MovieList",() => {
    const input=create(<MovieList movies={movies} />);
    expect(input.toJSON()).toMatchSnapshot();
})