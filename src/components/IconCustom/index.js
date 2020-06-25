import React from 'react';
import PropTypes from 'prop-types';
import { SvgCss } from 'react-native-svg';

export default function IconCustom({ color, ...rest }) {
  return <SvgCss {...rest} fill={color} />;
}

IconCustom.propTypes = {
  color: PropTypes.string.isRequired,
};