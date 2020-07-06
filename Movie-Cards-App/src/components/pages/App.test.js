import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import App from './App'
import { __esModule } from 'react-modal-video';
import { getByTitle, getByLabelText, render } from '@testing-library/react';

jest.mock('./../organisms/Movies', () => ({
    __esModule: true,
    default: () => { return <div></div>}
}))

jest.mock('./../atoms/Header/Header', () => ({
    __esModule: true,
    default: () => { return <div></div>}
}))


test("Match the snapshot - App",() => {
    const input=create(<App/>);
    expect(input.toJSON()).toMatchSnapshot();
})