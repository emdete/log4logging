#!/usr/bin/env -S make -f

all: $(PROJECT)_$(VERSION)_$(ARCH).deb

$(PROJECT)_$(VERSION)_$(ARCH).deb: debian-binary data.tar.gz control.tar.gz
	ar -r $(PROJECT)_$(VERSION)_$(ARCH).deb debian-binary control.tar.gz data.tar.gz

debian-binary: debian.mk
	echo 2.0 > debian-binary

control.tar.gz: control preinst postrm
	fakeroot tar czvf control.tar.gz control preinst postrm

data.tar.gz: debian.mk src/usr/share/java/log4j-core.jar src/usr/share/doc/$(PROJECT)/README
	fakeroot tar czvCf src data.tar.gz usr

control: debian.mk
	echo "Package: $(PROJECT)" > control
	echo "Version: $(VERSION)" >> control
	echo "Section: user/misc" >> control
	echo "Priority: optional" >> control
	echo "Depends: $(DEPENDS)" >> control
	echo "Architecture: $(ARCH)" >> control
	echo "Installed-Size: `du -ks src | cut -f 1`" >> control
	echo "Maintainer: $(MAINTAINER)" >> control
	echo "Provides: $(PROVIDES)" >> control
	echo "Replaces: $(PROVIDES)" >> control
	echo "Conflicts: $(PROVIDES)" >> control
	echo "Description: This package provides $(PROJECT)." >> control

preinst: debian.mk
	echo '#!/bin/sh' > preinst
	echo 'exit 0' >> preinst

postrm: debian.mk
	echo '#!/bin/sh' > postrm
	echo 'exit 0' >> postrm

clean:
	rm -f data.tar.gz control.tar.gz debian-binary $(PROJECT)_$(VERSION)_$(ARCH).deb control postrm preinst

src/usr/share/doc/$(PROJECT)/README: debian.mk
	mkdir -pv src/usr/share/doc/$(PROJECT)
	echo This package provides the $(PROJECT). > src/usr/share/doc/$(PROJECT)/README

src/usr/share/java/log4j-core.jar: log4logging.jar
	mkdir -p src/usr/share/java
	cp -v $< $@

