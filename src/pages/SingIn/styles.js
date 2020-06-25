import { Platform } from 'react-native';
import styled from 'styled-components/native';

import { colors } from '~/styles/themes';

import Input from '~/components/Input';
import Button from '~/components/Button';

export const Container = styled.KeyboardAvoidingView.attrs({
  enabled: Platform.OS === 'ios',
  behavior: 'padding',
})`
  flex: 1;
  justify-content: center;
  align-items: center;
  padding: 0 38px;
  background: ${colors.primary};
`;

export const Form = styled.View`
  align-self: stretch;
`;
export const FormInput = styled(Input)`
  margin-bottom: 10px;
`;

export const SubmitButton = styled(Button)`
  margin: 15px 80px;
  background: ${colors.dark};
`;

