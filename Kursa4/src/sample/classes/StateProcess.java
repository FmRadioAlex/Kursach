package sample.classes;

public enum StateProcess {
    NEW{
        @Override
        public String toString(){
            return "Новый";
        }
    },
    RUNNING{
        @Override
        public String toString(){
            return "Выполняемый";
        }
    },
    WAITING{
        @Override
        public String toString(){
            return "Ожидающий";
        }
    },
    READY{
        @Override
        public String toString(){
            return "Готовый";
        }
    },
    TERMINATED{
        @Override
        public String toString(){
            return "Завершённый";
        }
    },
    REJECTED{
        @Override
        public String toString(){return "Отклонённый"; }
    }
}
