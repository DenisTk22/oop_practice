package practice_2.task;

public interface Runner {

    String getName(); // ������ ������ ���� ����������, ����� ������������ � ������� �� ���������

    int getMaxRun();

    int getMaxJump();

    /**
     * ������
     *
     * @param height ������ ������
     * @return ��������� ������
     */


    default boolean jump(int height) { //����� �� ���������
        if (height <= getMaxJump()) {
            System.out.printf("%s ������� ����������� ����� ������� %s �.\n", getName(), height);
            return true;
        } else {
            System.out.printf("%s �� ���� ������������ ����� ����� %s �. ������� �� �����.\n", getName(), height);
            return false;
        }
    }

    default boolean run(int distance) { // ����� �� ���������
        if (distance <= getMaxRun()) {
            System.out.printf("%s ������� �������� ��������� %s �.\n", getName(), distance);
            return true;
        } else {
            System.out.printf("%s �� ���� ��������� ��������� %s �.\n", getName(), distance);
            return false;
        }
    }
}



