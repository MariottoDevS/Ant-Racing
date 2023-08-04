package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(countRound(3, 3, 1));
    }

    public static int countRound(int lengthLine, int leftPos, int rightPos) {
        int rounds = 0;
//           =========================Проверка условий задачи=========================
        if ((lengthLine >= 1 && lengthLine <= 10_000) && (leftPos >= 0 && leftPos <= lengthLine) && (rightPos >= 0 && rightPos <= lengthLine) && leftPos != rightPos) {
//          =========================Проверка изначального местоположения=========================
            if (Math.abs(rightPos - leftPos) > 2) {

//          ========================= Первый -  дальше =========================
                if (rightPos - leftPos > 2) {
                    while (rightPos - leftPos > 2) {
                        rounds++;
                        rightPos--;
                        leftPos++;
                    }
                    if (rightPos - leftPos <= 2 && rightPos - leftPos > 0) {
                        if (rightPos - leftPos == 1) {
                            rounds++;
                            leftPos--;
                            rightPos++;
                        } else {
                            rounds++;
                            leftPos--;
                            rightPos--;
                        }
                        while (rightPos <= lengthLine + 1 && leftPos >= -1) {
                            rounds++;
                            leftPos--;
                            rightPos++;
                        }
                    }
//           ========================= Второй - дальше=========================
                } else if (leftPos - rightPos > 2) {
                    while (leftPos - rightPos > 2) {
                        rounds++;
                        rightPos++;
                        leftPos--;
                    }
                    if (leftPos - rightPos <= 2 && leftPos - rightPos > 0) {
                        if (leftPos - rightPos == 1) {
                            leftPos++;
                            rightPos--;
                        } else {
                            leftPos--;
                            rightPos--;
                        }
                        while (leftPos <= lengthLine + 1 && rightPos >= -1) {
                            rounds++;
                            leftPos++;
                            rightPos--;
                        }
                    }
                }
//                ========================= Сразу change Route =========================
            } else {
                if (rightPos - leftPos <= 2 && rightPos - leftPos > 0) {
                    if (rightPos - leftPos == 1) {
                        leftPos--;
                        rightPos++;
                    } else {
                        leftPos--;
                        rightPos--;
                    }
                    while (rightPos <= lengthLine + 1 && leftPos >= -1) {
                        rounds++;
                        leftPos--;
                        rightPos++;
                    }
                } else if (leftPos - rightPos <= 2 && leftPos - rightPos > 0) {
                    if (leftPos - rightPos == 1) {
                        leftPos++;
                        rightPos--;
                    } else {
                        leftPos--;
                        rightPos--;
                    }
                    while (leftPos <= lengthLine + 1 && rightPos >= -1) {
                        rounds++;
                        leftPos++;
                        rightPos--;
                    }
                }
            }
        }
        return rounds;
    }
}