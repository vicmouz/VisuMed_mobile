import styled from 'styled-components/native';

import { colors } from '~/styles/themes';

export const Container = styled.View`
  padding: 0 10px;
  height: 46px;
  background: ${colors.light};
  border-radius: 4px;

  flex-direction: row;
  align-items: center;
`;

export const TInput = styled.TextInput.attrs({
  placeholderTextColor: colors.dark,
})`
  flex: 1;
  font-size: 16px;
  margin-left: 5px;
  color: ${colors.dark};
`;
