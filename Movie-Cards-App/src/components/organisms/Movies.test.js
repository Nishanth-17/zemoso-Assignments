import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import Movies from './Movies'
import { __esModule } from 'react-modal-video';

jest.mock('./../organisms/MovieList', () => ({
    __esModule: true,
    default: () => { return <div></div>}
}))
test("Match the snapshot - Movies",() => {
    const input=create(<Movies />);
    expect(input.toJSON()).toMatchSnapshot();
})