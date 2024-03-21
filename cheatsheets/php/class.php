<?php

interface Printable
{
    protected function print(): void;
}

abstract class Base
{
    // Force Extending class to define this method
    abstract public function getCallable(): callable;
}

trait Play
{
    // Traits can, as of PHP 8.2.0, also define constants.
    final public const PLAY = 'Play';

    public function dialog()
    {
        echo "Playing";
    }

    public function submit()
    {
        echo 'Submit Play';
    }
}

trait Modify
{
    public function dialog()
    {
        echo "Modifying";
    }

    public function submit()
    {
        echo 'Submit Modify';
    }
}


#[\AllowDynamicProperties] // Dynamic properties are deprecated as of PHP 8.2.0, thus using them without marking the class with this attribute will emit a deprecation notice.
class Foo extends Base implements Printable
{
    use Play, Modify {
        Play::dialog insteadof Modify;
        Modify::dialog as modifyDialog;
        Modify::submit insteadof Play;
    }

    public string $var = 'default value';

    protected readonly static int $ro = 1; //As of PHP .8.10, a property can be declared with the readonly modifier, which prevents modification of the property after initialization.

    private const TYPE_A = 'A'; // Class constant visibility modifiers, as of PHP 7.1.0

    const int MASK_B = 2; // Typed class constants, as of PHP 8.3


    public function __construct(string $value = 'another default value')
    {
        $this->var = $value;
        $this->var1 = 'dyn val';
    }

    function __destruct()
    {
        // DO SOMETHING
    }

    protected function print(): void
    {
        $this->dialog();
        $this->modifyDialog();
        $this->submit();
        echo 'protected method';
    }

    #[\Override] // By adding the #[\Override] attribute to a method, PHP will ensure that a method with the same name exists in a parent class or in an implemented interface. Adding the attribute makes it clear that overriding a parent method is intentional and simplifies refactoring, because the removal of an overridden parent method will be detected.
    public function getCallable(): callable
    {
        return fn() => true;
    }

    public static function fromObject(object $obj): self
    {
        $s = new self;
        // DO SOMETHING;
        return $s;
    }

}

readonly class Foo2
{ // As of PHP 8.2.0, a class can be marked with the readonly modifier

}

// Anonymous classes
Foo::fromObject(new class{
    // SOME CLASS PROPERTIES AND METHODS
});


