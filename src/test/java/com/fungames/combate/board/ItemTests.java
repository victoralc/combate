package com.fungames.combate.board;

import com.fungames.combate.pieces.Bomb;
import com.fungames.combate.pieces.Prisoner;
import com.fungames.combate.pieces.SecretAgent;
import com.fungames.combate.pieces.direction.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTests {
    private Item item;

    @BeforeEach
    void setUp() {
        item = Item.createItem(SecretAgent.create(), Position.of(4, 7));
    }

    @Test
    void createItemSuccess() {
        assertNotNull(item);
        assertInstanceOf(Item.class, item);
        assertEquals(item.getPiece(), SecretAgent.create());
        assertEquals(item.getCurrentPosition(), Position.of(4, 7));
    }

    @Test
    void shouldSetANewPositionWhenDirectionIsUp() {
        item.move(Direction.UP);
        assertEquals(item.getCurrentPosition(), Position.of(3, 7));
    }

    @Test
    void shouldSetANewPositionWhenDirectionIsDown() {
        item.move(Direction.DOWN);
        assertEquals(item.getCurrentPosition(), Position.of(5, 7));
    }

    @Test
    void shouldSetANewPositionWhenDirectionIsLeft() {
        item.move(Direction.LEFT);
        assertEquals(item.getCurrentPosition(), Position.of(4, 6));
    }

    @Test
    void shouldSetANewPositionWhenDirectionIsRight() {
        item.move(Direction.RIGHT);
        assertEquals(item.getCurrentPosition(), Position.of(4, 8));
    }

    @Test
    void shouldNotMoveABombItem() {
        var bomb = Item.createItem(Bomb.newBomb(), Position.of(4, 7));

        bomb.move(Direction.RIGHT);
        assertEquals(bomb.getCurrentPosition(), Position.of(4, 7));
    }

    @Test
    void shouldNotMoveAPrisonerItem() {
        var prisoner = Item.createItem(Prisoner.create(), Position.of(4, 7));

        prisoner.move(Direction.UP);
        assertEquals(prisoner.getCurrentPosition(), Position.of(4, 7));
    }

    @Test
    void shouldNotMoveItemWhenThePositionExceedTheLimitOfTheBoardGrid() {
        item = Item.createItem(SecretAgent.create(), Position.of(9, 7));
        item.move(Direction.DOWN);
        assertEquals(item.getCurrentPosition(), Position.of(9, 7));
    }
}