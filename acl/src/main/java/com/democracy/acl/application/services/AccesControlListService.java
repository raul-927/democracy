package com.democracy.acl.application.services;

import com.democracy.acl.domain.models.Eployee;
import com.democracy.acl.domain.models.Product;
import com.democracy.acl.domain.models.enums.RolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AccesControlListService<T> {
	
	@Autowired
	private MutableAclService mutableAclService;
	private static final String DOMAIN ="com.democracy.domain.model.";
	
	public int insert(T object) {
		Integer id = Math.abs(object.hashCode());
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		ObjectIdentity objectIdentity  = null;
		MutableAcl mutableAcl = null;
		String getClase = object.getClass().getCanonicalName();
		switch (getClase) {
			case DOMAIN+"Product":
				objectIdentity = new ObjectIdentityImpl(Product.class, ((Product)object).getProductId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.CONFIG.getDescripcion()), true);
				break;
			case DOMAIN+"Eployee":
				objectIdentity = new ObjectIdentityImpl(Eployee.class, ((Eployee)object).getEmployeeId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.CONFIG.getDescripcion()), true);
				break;
		}
		mutableAclService.updateAcl(mutableAcl);
		return id;
	}

	public void delete(T object) {
		ObjectIdentity oid = null;
		String getClase = object.getClass().getName();
		
		switch(getClase) {
			case DOMAIN+"Product":
				oid = new ObjectIdentityImpl(Product.class, ((Product) object).getProductId());
				break;
			case DOMAIN+"Eployee":
				oid = new ObjectIdentityImpl(Eployee.class, ((Eployee) object).getEmployeeId());
				break;
			default:
				break;
		}
		mutableAclService.deleteAcl(oid, true);
	}
	
	public void setMutableAclService(MutableAclService mutableAclService) {
		this.mutableAclService = mutableAclService;
	}
}
