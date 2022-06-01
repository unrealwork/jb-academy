package carsharing.service.dao;

final class Util {
    private Util() {
        
    }

    static String concatObjects(Object... objs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objs.length; i++) {
            sb.append(objs[i]);
            if (i != objs.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
