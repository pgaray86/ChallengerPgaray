package ar.com.bago.challenge01.model;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicResponse {

    private int id;
    private String value;

    public BasicResponse() {
    }

    public BasicResponse(int id, String value) {
        this.id = id;
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicResponse that = (BasicResponse) o;
        return id == that.id && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @Override
    public String toString() {
        return "BasicResponse{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
