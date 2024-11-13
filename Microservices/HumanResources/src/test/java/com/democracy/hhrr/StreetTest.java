package com.democracy.hhrr;

import com.democracy.hhrr.application.services.StreetServiceImpl;
import com.democracy.hhrr.application.usecases.street.CreateStreetUseCase;
import com.democracy.hhrr.application.usecases.street.SelectStreetUseCase;
import com.democracy.hhrr.domain.enums.StreetType;
import com.democracy.hhrr.domain.models.Street;
import com.democracy.hhrr.domain.ports.out.StreetOut;
import com.democracy.hhrr.infrastructure.adapters.StreetAdapter;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.StreetDynamicMapper;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.StreetMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.Op;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class StreetTest {

    @Mock
    private StreetDynamicMapper streetMapper;

    @Mock
    private SelectStreetUseCase selectStreetUseCaseMock;

    @Mock
    private CreateStreetUseCase createStreetUseCaseMock;

    @InjectMocks
    private StreetServiceImpl streetService;


    @Test
    @Disabled
    public void createStreetTest(){
        //given
        Street street = new Street();
        street.setStreetName("Prueba1");
        street.setStreetType(StreetType.CA);
        street.setStreetId("cccccc");
        //When
        given(createStreetUseCaseMock.createStreet(street))
                .willReturn(Mono.just(1));
        var streets = streetService.selectStreet(street);
        //Then
        assertThat(streets).isNotNull();
        assertThat(Objects
                .requireNonNull(streets.count().block()).longValue())
                .isEqualTo(
                        Objects
                                .requireNonNull(Flux.just(street, streets.blockFirst()).count().block()).longValue());


    }

    @Test
    public void selectAllStreetTest(){
        //given
        Street street = new Street();
        street.setStreetName("Prueba1");
        street.setStreetType(StreetType.CA);
        street.setStreetId("aaaaaa");

        Street street2 = new Street();
        street2.setStreetName("Prueba2");
        street2.setStreetType(StreetType.K);
        street2.setStreetId("bbbbbb");

        //When
        given(streetService.selectStreet(new Street()))
                .willReturn(Flux.just(street, street2));
        var streets = streetService.selectStreet(new Street());
        //Then
        assertThat(streets).isNotNull();
        assertThat(Objects
                .requireNonNull(streets.count().block()).longValue())
                .isEqualTo(
                        Objects
                                .requireNonNull(Flux.just(street, street2).count().block()).longValue());
    }

    @Test
    public void selectOneStreetByIdTest(){
        //given
        Street street = new Street();
        street.setStreetId("aaaaaa");
        //When
        given(streetService.selectStreet(street))
                .willReturn(Flux.just(street));
        var streets = streetService.selectStreet(street);

        //THEN
        assertThat(streets).isNotNull();
        assertThat(Objects
                .requireNonNull(streets.count().block()).longValue())
                .isEqualTo(
                        Objects
                                .requireNonNull(Flux.just(street).count().block()).longValue());

    }
    @Test
    public void selectOneStreetByNameTest(){
        //given
        Street street = new Street();
        street.setStreetName("Prueba1");
        //When
        given(streetService.selectStreet(street))
                .willReturn(Flux.just(street));
        var streets = streetService.selectStreet(street);
        assertThat(streets).isNotNull();

        assertThat(Objects
                .requireNonNull(streets.count().block()).longValue())
                .isEqualTo(
                        Objects
                                .requireNonNull(Flux.just(street).count().block()).longValue());

    }
    @Test
    public void selectOneStreetByTypeTest(){
        //given
        Street street = new Street();
        street.setStreetType(StreetType.CA);

        //When
        given(streetService.selectStreet(street))
                .willReturn(Flux.just(street));
        var streets = streetService.selectStreet(street);
        assertThat(streets).isNotNull();

        assertThat(Objects
                .requireNonNull(streets.count().block()).longValue())
                .isEqualTo(
                        Objects
                                .requireNonNull(Flux.just(street).count().block()).longValue());

    }
}