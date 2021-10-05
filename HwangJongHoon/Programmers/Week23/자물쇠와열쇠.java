public class 자물쇠와열쇠 {
    class Solution {
        int M, N;

        public boolean solution(int[][] key, int[][] lock) {
            int size = lock.length - 1;
            M = key.length;
            N = lock.length;

            for (int i = 0; i < 4; ++i) {
                int[][] rotatedKey = rotate(i, key);
                int[][] paddedKey = padding(rotatedKey, size);

                for (int R = 0; R < paddedKey.length - size; ++R) {
                    for (int C = 0; C < paddedKey.length - size; ++C) {
                        boolean flag = true;

                        for (int r = 0; r < N; ++r) {
                            for (int c = 0; c < N; ++c) {
                                if (lock[r][c] == paddedKey[R + r][C + c]) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (flag) return true;
                    }
                }
            }

            return false;
        }

        private int[][] padding(int[][] arr, int size) {
            int[][] result = new int[arr.length + size * 2][arr[0].length + size * 2];

            for (int r = 0; r < arr.length; ++r) {
                for (int c = 0; c < arr[0].length; ++c) {
                    result[r + size][c + size] = arr[r][c];
                }
            }
            return result;
        }

        private int[][] rotate(int cnt, int[][] arr) {
            if (cnt == 0) return arr;

            int[][] result = null;
            int[][] origin = copy(arr);

            for (int i = 0; i < cnt; ++i) {
                result = new int[M][M];

                for (int r = 0; r < M; ++r) {
                    for (int c = 0; c < M; ++c) {
                        result[c][origin.length - 1 - r] = origin[r][c];
                    }
                }
                origin = result;
            }

            return result;
        }

        private int[][] copy(int[][] arr) {
            int[][] result = new int[M][M];

            for (int r = 0; r < M; ++r) {
                for (int c = 0; c < M; ++c) {
                    result[r][c] = arr[r][c];
                }
            }

            return result;
        }
    }
}