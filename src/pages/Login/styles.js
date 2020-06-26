import { Platform } from 'react-native';
import styled from 'styled-components/native';

import { colors } from '~/styles/themes';

import Input from '~/components/Input';
import Button from '~/components/Button';
import { responsiveSize } from '~/styles/themes/responsive';

export const Container = styled.KeyboardAvoidingView.attrs({
  enabled: Platform.OS === 'ios',
  behavior: 'padding',
})`
  flex: 1;
  justify-content: center;
  align-items: center;
  padding: 0 38px;
  background: ${colors.light};
`;

export const Form = styled.View``;
export const FormInput = styled(Input)`
  margin-bottom: 10px;
`;

export const SubmitButton = styled(Button)`
  width: ${responsiveSize(278)}px;
  height: ${responsiveSize(52)}px;
  background: ${colors.secondary};
  margin-bottom: ${responsiveSize(22)}px;
`;

export const RecoverButton = styled(Button)`
  width: ${responsiveSize(278)}px;
  height: ${responsiveSize(52)}px;
  background: ${colors.light};
  border: 1px solid ${colors.secondary};
  color: ${colors.secondary};
`;

export const FacebookButton = styled(Button)`
  width: ${responsiveSize(278)}px;
  height: ${responsiveSize(52)}px;
  background: ${colors.facebook};
  margin-bottom: ${responsiveSize(14)}px;
  font-weight: 700;
`;

export const GoogleButton = styled(Button)`
  width: ${responsiveSize(278)}px;
  height: ${responsiveSize(52)}px;
  background: ${colors.google};
  margin-bottom: ${responsiveSize(53)}px;
  font-weight: 700;
`;
